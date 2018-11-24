from selenium import webdriver

# initiate
driver = webdriver.Chrome()  # initiate a driver, in this case Firefox
driver.get(" add url here!!! ")  # go to the url

# locate the login form
username_field = driver.find_element_by_name("login")  # get the username field
password_field = driver.find_element_by_name("password")  # get the password field

# log in
username_field.send_keys("#your_login")  # enter in your username
password_field.send_keys("#your_password")  # enter in your password
driver.find_element_by_name("submit").click()  # submit it

# print HTML
html = driver.page_source
print(html)


