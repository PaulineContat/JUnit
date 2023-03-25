import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyDateTest {

	/**
     * Test method for {@link MyDate#getDay()}.
     */
	@Test
    public void testGetDay() {
        MyDate d = new MyDate(31, 12, 2006);
        assertEquals(31, d.getDay());
    }

    /**
     * Test method for {@link MyDate#getMonth()}.
     */
	@Test
    public void testGetMonth() {
		MyDate d = new MyDate(31, 12, 2006);
        assertEquals(12, d.getMonth());
    }

    /**
     * Test method for {@link MyDate#getYear()}.
     */
	@Test
    public void testGetYear() {
		MyDate d = new MyDate(31, 12, 2006);
        assertEquals(2006, d.getYear());
    }

    /**
     * Test method for {@link MyDate#checkData()} .
     */
	@Test
    public void testCheckData() {
		MyDate d1 = new MyDate(31, 12, 2006);
		assertTrue(d1.checkData());
    }

    /**
     * Test simple valid dates
     */
	@Test
    public void testSimpleValidDates() {
        boolean b1 = MyDate.isValidDate(1, 1, 2000);
		boolean b2 = MyDate.isValidDate(29, 2, 2000);
		boolean b3 = MyDate.isValidDate(31, 12, 2000);
		assertAll("Test de dates valides",
			()->assertTrue(b1),
			()->assertTrue(b2, "jour 29 est valide pour une année bissextile"),
			()->assertTrue(b3)
		);
    }

    /**
     * Test simple invalid dates
     */
	@Test
    public void testSimpleInvalidDates() {
        boolean b1 = MyDate.isValidDate(0, 1, 2000);
        boolean b2 = MyDate.isValidDate(32, 12, 2000);
		boolean b3 = MyDate.isValidDate(31, 12, 2033);
		boolean b4 = MyDate.isValidDate(31, 12, 1811);
		boolean b5 = MyDate.isValidDate(31, 4, 2006);
		boolean b6 = MyDate.isValidDate(29, 2, 2001);
        assertAll("Test de dates invalides",
        		()->assertFalse(b1, "jour 0 est invalide"),
        		()->assertFalse(b2, "jour 32 est invalide"),
        		()->assertFalse(b3, "année 2033 est invalide"),
        		()->assertFalse(b4, "année 1811 est invalide"),
        		()->assertFalse(b5, "jour 31 est invalide pour avril"),
        		()->assertFalse(b6, "jour 29 du mois de février est invalide pour une année non bissextile")
        );
    }

    /**
     * Test valid limit dates
     */
	@Test
    public void testValidLimitDates() {
        boolean b = MyDate.isValidDate(31, 1, 2000);
        assertTrue(b,"31 janvier est une date valide");
    }

    /**
     * Test invalid limit dates
     */
	@Test
    public void testInvalidLimitDates() {
        boolean b = MyDate.isValidDate(31, 4, 2000);
        assertFalse(b,"31 avril est une date invalide");
    }

    /**
     * Test February valid limit dates
     */
	@Test
    public void testFebruaryValidLimitDates() {
        boolean b = MyDate.isValidDate(29, 2, 2000);
        assertTrue(b,"29 février 2000 est une date valide");
    }

    /**
     * Test February invalid limit dates
     */
	@Test
    public void testFebruaryInvalidLimitDates() {
        boolean b = MyDate.isValidDate(29, 2, 2001);
        assertFalse(b,"29 février 2001 est une date invalide");
    }

}
