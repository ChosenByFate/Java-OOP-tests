import os.path
from selenium import webdriver
import time
import sys
import math

def calc(x):
  return str(math.log(abs(12*math.sin(int(x)))))

try:
    # link = "http://suninjuly.github.io/alert_accept.html"
    link = "http://suninjuly.github.io/redirect_accept.html"

    browser = webdriver.Chrome(sys.argv[1]) if len(sys.argv) > 1 else webdriver.Chrome()
    browser.get(link)

    browser.find_element_by_css_selector('[type="submit"]').click()

    second_window = browser.window_handles[1]
    browser.switch_to.window(second_window)

    x = browser.find_element_by_css_selector('[id="input_value"]').text

    input_ = browser.find_element_by_css_selector('input[id="answer"]')
    input_.send_keys(calc(x))

    # Отправляем заполненную форму
    button = browser.find_element_by_css_selector("button.btn")
    browser.execute_script("return arguments[0].scrollIntoView(true);", button)
    button.click()
finally:
    # ожидание чтобы визуально оценить результаты прохождения скрипта
    time.sleep(10)
    # закрываем браузер после всех манипуляций
    browser.quit()
