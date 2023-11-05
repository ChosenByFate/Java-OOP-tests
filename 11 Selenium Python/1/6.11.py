from selenium import webdriver
import time
import sys

try:
    # link = "http://suninjuly.github.io/registration1.html"
    link = "http://suninjuly.github.io/registration2.html"

    browser = webdriver.Chrome(sys.argv[1]) if len(sys.argv) > 1 else webdriver.Chrome()
    browser.get(link)

    # Ваш код, который заполняет обязательные поля
    web_elements = browser.find_elements_by_xpath('//div[@class="first_block"]//input[@type="text"]')
    assert len(web_elements) == 3, "Нехватает обязательных полей!"
    for web_element in web_elements:
        web_element.send_keys("Some text.")

    # Отправляем заполненную форму
    button = browser.find_element_by_css_selector("button.btn")
    button.click()

    # Проверяем, что смогли зарегистрироваться
    # ждем загрузки страницы
    time.sleep(1)

    # находим элемент, содержащий текст
    welcome_text_elt = browser.find_element_by_tag_name("h1")
    # записываем в переменную welcome_text текст из элемента welcome_text_elt
    welcome_text = welcome_text_elt.text

    # с помощью assert проверяем, что ожидаемый текст совпадает с текстом на странице сайта
    assert "Congratulations! You have successfully registered!" == welcome_text

finally:
    # ожидание чтобы визуально оценить результаты прохождения скрипта
    time.sleep(10)
    # закрываем браузер после всех манипуляций
    browser.quit()
