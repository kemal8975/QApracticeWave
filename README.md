1-) Implemented get and post request, however since weatherAPI doesn't allow me to do a post request I’ve simulated it by sending body params with q=bulk).
2-) Very simple CSV file for data driven testing to show the skills
3-) used json-schema-validator library for schema validation
4-) Automated 2 UI test case. Used POM
5-) Report generation is present as well as screenshot but takes screenshots only if the test case fails.
6-) Can run on multiple browsers.
7-) Performance testing wouldn't be much possible with selenium however with given time I can create a small performance testing "framework" with Jmeter and combine it with selenium


Notes:

1-) I can also create this same framework in Playwright and Cypress, which would have taken me much shorter to do since most of the stuff in the JS Frameworks comes as ready but to show my skillcase I have created one in selenium
