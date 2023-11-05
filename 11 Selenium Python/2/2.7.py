import os.path

from selenium import webdriver
import time
import sys

try:
    link = "http://suninjuly.github.io/file_input.html"

    browser = webdriver.Chrome(sys.argv[1]) if len(sys.argv) > 1 else webdriver.Chrome()
    browser.get(link)

    web_elements = browser.find_elements_by_xpath('//div[@class="form-group"]//input[@type="text"]')
    for web_element in web_elements:
        web_element.send_keys("Some text.")

    upload = browser.find_element_by_css_selector('[type="file"]')
    current_path = os.path.abspath(os.path.dirname(__file__))
    path = os.path.join(current_path, '2.7.txt')
    upload.send_keys(path)

    # Отправляем заполненную форму
    button = browser.find_element_by_css_selector("button.btn")
    browser.execute_script("return arguments[0].scrollIntoView(true);", button)
    button.click()
finally:
    # ожидание чтобы визуально оценить результаты прохождения скрипта
    time.sleep(10)
    # закрываем браузер после всех манипуляций
    browser.quit()
