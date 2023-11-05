from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium import webdriver
import time
import sys
import math

def calc(x):
  return str(math.log(abs(12*math.sin(int(x)))))

try:
    browser = webdriver.Chrome(sys.argv[1]) if len(sys.argv) > 1 else webdriver.Chrome()
    # говорим WebDriver ждать все элементы в течение 5 секунд
    # browser.implicitly_wait(15)

    link = "http://suninjuly.github.io/explicit_wait2.html"
    browser.get(link)

    WebDriverWait(browser, 15).until(EC.text_to_be_present_in_element((By.CSS_SELECTOR, '[id="price"]'), "$100"))

    button = browser.find_element_by_id("book")
    button.click()

    text = browser.find_element_by_id("input_value")
    browser.execute_script("return arguments[0].scrollIntoView(true);", text)
    x = text.text
    browser.find_element_by_id("answer").send_keys(calc(x))

    button = browser.find_element_by_css_selector('button[id="solve"]')
    browser.execute_script("return arguments[0].scrollIntoView(true);", button)
    button.click()
finally:
    # ожидание чтобы визуально оценить результаты прохождения скрипта
    time.sleep(10)
    # закрываем браузер после всех манипуляций
    browser.quit()