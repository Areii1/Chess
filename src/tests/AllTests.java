package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Pawntest.class, Rooktest.class, Bishoptest.class, QueenTest.class, KnightTest.class, KingTest.class })
public class AllTests {

}
