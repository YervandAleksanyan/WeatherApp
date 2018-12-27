package dev.yervand.weatherapp.test

//class TestSteps : Instrumentation() {
//   @Rule
//    private var activityTestRule: ManualTestRule<WeatherActivity> = ManualTestRule(WeatherActivity::class.java)

//   @Before
//   fun initialSetup() {
//        Intents.init()
//   }

//    @After
//   fun tearDown() {
//      Intents.release()
//
//   }

//    @Given("^I have navigated to Weather screen$")
//    @Test
//    fun i_have_navigated_to_Weather_screen() {
//        activityTestRule.launchActivity(Intent())
//        ScreenShotter.takeScreenshot("^I have navigated to Weather screen", activityTestRule.activity)
//    }
//
//    @When("^List of cities will  created$")
//    @Test
//    fun list_of_cities_will_created() {
//        WeatherModel.checkCitiesListNotEmpty()
//        ScreenShotter.takeScreenshot("^List of cities will  created$", activityTestRule.activity)
//    }
//
//    @Then("^A cities list first item should be the same the entered data set first item$")
//    @Test
//    fun a_cities_list_first_item_should_be_the_same_the_entered_data_set_first_item() {
//        assert(true)
//        ScreenShotter.takeScreenshot("^List of cities will  created$", activityTestRule.activity)
//    }
//}