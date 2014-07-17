/**
 * Copyright (c) 2009 Cliffano Subagio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.plugins.chucknorris;

import java.util.Random;

/**
 * {@link FactGenerator} provides Chuck Norris facts.
 * @author cliffano
 */
public class FactGenerator {


	/**
     * Random instance.
     */
    private static final Random RANDOM = new Random();

    /**
     * Retrieves a random fact.
     * @return a random fact
     */
    public String random() {
    	String[] FACTS = getFacts();
        return FACTS[RANDOM.nextInt(FACTS.length)];
    }

	private static String[] getFacts() {
		String file = System.getProperty("user.home") + "/.team-quotes/quotes.txt";
		try {
			return TextFileUtils.getContents(file).trim().split("\n");
		} catch (Exception e) {
			return new String[]{"could not retrieve quotes from " + file + " because " + e.getMessage()};
		}
	}
}
