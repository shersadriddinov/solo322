from selenium import webdriver

# initiate
driver = webdriver.Chrome()  # initiate a driver, in this case Firefox
driver.get("https://www.marathonbet.com/su/")  # go to the url

# locate the login form
username_field = driver.find_element_by_name("login")  # get the username field
password_field = driver.find_element_by_name("login_password")  # get the password field

# log in
username_field.send_keys("jasurkhakimov")  # enter in your username
password_field.send_keys("carpediem9")  # enter in your password
driver.find_element_by_tag_name("button").click()  # submit it

# print HTML
html = driver.page_source
print(html)

# 71114211
# yht73u2a
