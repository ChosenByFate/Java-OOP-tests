from selenium import webdriver
import time
import sys
import math

def calc(x):
  return str(math.log(abs(12*math.sin(int(x)))))

try:
    link = "http://suninjuly.github.io/execute_script.html"

    browser = webdriver.Chrome(sys.argv[1]) if len(sys.argv) > 1 else webdriver.Chrome()
    browser.get(link)

    x = browser.find_element_by_css_selector('[id="input_value"]').text

    browser.find_element_by_css_selector('[id="answer"]').send_keys(calc(x))

    check_box = browser.find_element_by_css_selector('input[type="checkbox"]')
    check_box.click()

    browser.execute_script("window.scrollBy(0, 100);")
    radio_button = browser.find_element_by_css_selector('input[id="robotsRule"]')
    radio_button.click()

    # Отправляем заполненную форму
    button = browser.find_element_by_css_selector("button.btn")
    browser.execute_script("return arguments[0].scrollIntoView(true);", button)
    button.click()
finally:
    # ожидание чтобы визуально оценить результаты прохождения скрипта
    time.sleep(10)
    # закрываем браузер после всех манипуляций
    browser.quit()
