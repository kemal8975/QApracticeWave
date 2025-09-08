Implemented GET and POST requests. However, since WeatherAPI doesn’t allow POST requests, I simulated it by sending body parameters with q=bulk.

Created a simple CSV file for data-driven testing to demonstrate skills.

Used the json-schema-validator library for schema validation.

Automated 2 UI test cases using the Page Object Model (POM).

Implemented report generation and screenshots, with screenshots captured only when a test case fails.

Tests can run on multiple browsers.

Performance testing isn’t very feasible with Selenium. However, given more time, I can create a lightweight performance testing framework with JMeter and integrate it with Selenium.

Notes:

I can also build this same framework in Playwright or Cypress, which would have taken me less time since many features come ready-to-use in JavaScript frameworks. However, I chose Selenium to better showcase my skill set.
