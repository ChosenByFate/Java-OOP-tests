from selenium import webdriver
import time
import sys

try:
    browser = webdriver.Chrome(sys.argv[1])
    browser.get("http://suninjuly.github.io/huge_form.html")
    value = 'input'
    elements = browser.find_elements_by_css_selector(value)
    for element in elements:
        element.send_keys("Мой ответ")

    button = browser.find_element_by_css_selector("button.btn")
    button.click()

finally:
    # успеваем скопировать код за 30 секунд
    time.sleep(10)
    # закрываем браузер после всех манипуляций
    browser.quit()

# не забываем оставить пустую строку в конце файла