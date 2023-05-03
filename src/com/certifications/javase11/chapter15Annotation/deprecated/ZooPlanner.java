package src.com.certifications.javase11.chapter15Annotation.deprecated;

/**
 * Design and plan a zoo.
 * @deprecated Use ParkPlanner instead.
 */
//That's it! The users of the ZooPlanner class will now receive a compiler warning if they are using ZooPlanner
/*
Earlier, we discussed @Deprecated and @deprecated, the former being a Java annotation and the latter being a Javadoc annotation.
 Whenever you deprecate a method, you should add a Javadoc annotation to instruct users on how they should update their code.
 */
@Deprecated
public class ZooPlanner {

    /*
     @Deprecated annotation does support two optional values: String since() and boolean forRemoval()
     They provide additional information about when the deprecation occurred in the past and whether
    or not the type is expected to be removed entirely in the future.
     */
    /**
     * Method to formulate a zoo layout.
     * @deprecated Use ParkPlanner.planPark(String… data) instead.
     */
    @Deprecated(since="1.8", forRemoval=true)
    public void plan() {}

}
