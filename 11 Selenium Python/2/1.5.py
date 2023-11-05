from selenium import webdriver
import time
import sys
import math

def calc(x):
  return str(math.log(abs(12*math.sin(int(x)))))

try:
    # link = "http://suninjuly.github.io/math.html"
    link = "http://suninjuly.github.io/get_attribute.html"

    browser = webdriver.Chrome(sys.argv[1]) if len(sys.argv) > 1 else webdriver.Chrome()
    browser.get(link)

    # Ваш код, который заполняет обязательные поля
    # x = browser.find_element_by_css_selector('span[id="input_value"]').text
    x = browser.find_element_by_css_selector('[id="treasure"]').get_attribute('valuex')
    print(x)

    input_ = browser.find_element_by_css_selector('input[id="answer"]')
    input_.send_keys(calc(x))

    check_box = browser.find_element_by_css_selector('input[type="checkbox"]')
    check_box.click()

    radio_button = browser.find_element_by_css_selector('input[id="robotsRule"]')
    radio_button.click()

    # Отправляем заполненную форму
    button = browser.find_element_by_css_selector("button.btn")
    button.click()
finally:
    # ожидание чтобы визуально оценить результаты прохождения скрипта
    time.sleep(10)
    # закрываем браузер после всех манипуляций
    browser.quit()
