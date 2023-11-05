from selenium import webdriver
import time
import math

# link = "http://suninjuly.github.io/simple_form_find_task.html"
# link = "http://suninjuly.github.io/find_link_text"
link = "http://suninjuly.github.io/find_xpath_form"

try:
    browser = webdriver.Chrome('../chromedriver.exe')
    browser.get(link)

    # value = str(math.ceil(math.pow(math.pi, math.e)*10000))
    # browser.find_element_by_link_text(value).click()

    value1 = '[name="first_name"]'
    input1 = browser.find_element_by_tag_name(value1)
    input1.send_keys("Ivan")

    value2 = 'last_name'
    input2 = browser.find_element_by_name(value2)
    input2.send_keys("Petrov")

    value3 = 'form-control.city'
    input3 = browser.find_element_by_class_name(value3)
    input3.send_keys("Smolensk")

    value4 = 'country'
    input4 = browser.find_element_by_id(value4)
    input4.send_keys("Russia")

    button = browser.find_element_by_xpath('//button[text()="Submit"]')
    button.click()

finally:
    # успеваем скопировать код за 30 секунд
    time.sleep(10)
    # закрываем браузер после всех манипуляций
    browser.quit()

# не забываем оставить пустую строку в конце файла