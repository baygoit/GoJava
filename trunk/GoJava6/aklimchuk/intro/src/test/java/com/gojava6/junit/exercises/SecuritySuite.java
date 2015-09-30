package com.gojava6.junit.exercises;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by sergiigetman on 9/28/15.
 */
@RunWith(Categories.class)
@Suite.SuiteClasses({PoliceTest.class, SwatTest.class})
@Categories.IncludeCategory(CriminalCategory.class)
public class SecuritySuite {
}
