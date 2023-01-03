package myproject.StudyHalls;

public class Day_01 {
    /*challenges with selenium*/
    //1-) sync issue(timeout) -> in order to handle issue I use implicit and Explicit.
    // In my frameWork I do not recommend using Thread.Sleep() because it comes from Java, and it waits till time we provided
    //2-) Locating elements
    // it is hard to find smart locators.
    //3-) pop-up handling  //(JS-based pop-ups)//
    // we need to handle unwanted pop-up which stops our execution.
    /* Why i connot find elements
    * 1-) noSuchElementException
    * element is in hidden iframe(we neet to switch to iframe)
    * Sync issie (we need to use implicit and explicit wait)
    * element is dynamic (we need to use dynamic locator)
    */
    /*How do you handle dynamic element?
     * find the static parts of the elements and find the locator(xpath or css)
     * then use start-with,contains,ends-with, text()
     */
    /*using Listeners in TestNG
    * */
}
