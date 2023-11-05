from selenium import webdriver
from selenium.webdriver.support.ui import Select
import time
import sys

try:
    link = "http://suninjuly.github.io/selects1.html"

    browser = webdriver.Chrome(sys.argv[1]) if len(sys.argv) > 1 else webdriver.Chrome()
    browser.get(link)

    x1 = browser.find_element_by_css_selector('[id="num1"]').text
    x2 = browser.find_element_by_css_selector('[id="num2"]').text

    combobox = Select(browser.find_element_by_tag_name('select'))
    combobox.select_by_value(str(int(x1) + int(x2)))

    # Отправляем заполненную форму
    button = browser.find_element_by_css_selector("button.btn")
    button.click()
finally:
    # ожидание чтобы визуально оценить результаты прохождения скрипта
    time.sleep(10)
    # закрываем браузер после всех манипуляций
    browser.quit()
