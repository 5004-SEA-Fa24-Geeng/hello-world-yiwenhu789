package student;

/**
 * This class is a place holder which you will fully implement based on the javadoc.
 *
 * https://cs5004-khoury-lionelle.github.io/hello_world/student/package-summary.html
 *
 */
public class Greeting {
    /** ID of the locality. */
    private int localityID;

    /** Name of the locality. */
    private String localityName;

    /** Greeting using ASCII characters. */
    private String asciiGreeting;

    /** Greeting using Unicode characters. */
    private String unicodeGreeting;

    /** Format string for the greeting. */
    private String formatStr;

    /**
     * Default greeting that creates "Hello, {name}!".
     *
     * @param localityID   id of the locality
     * @param localityName name of the locality
     */
    public Greeting(int localityID, String localityName) {
        this(localityID, localityName, "Hello", "Hello", "%s, %%s!");
    }

    /**
     * Greeting that creates a greeting with ascii and unicode characters assuming the language
     * is already using ascii letters only. It also assumes the format of the greeting to be
     * "{greeting}, {name}!".
     *
     * For the default format string you will want to use "%s, %%s!" which places the greeting
     * before the person's potential name.
     *
     * @param localityID   id of the locality
     * @param localityName name of the locality
     * @param greeting     greeting using ascii characters
     */
    public Greeting(int localityID, String localityName, String greeting) {
        this(localityID, localityName, greeting, greeting, "%s, %%s!");
    }

    /**
     * Greeting that creates a greeting with ascii and unicode characters.
     * It makes no assumptions, and everything needs to be provided.
     *
     * Often the other constructors will call this very detailed constructor.
     * Using the following code (as an example, this is the code for one of the constructors):
     *
     * public Greeting(int localityID, String localityName, String greeting) {
     *     this(localityID, localityName, greeting, greeting, "%s, %%s!");
     * }
     *
     * @param localityID      id of the locality
     * @param localityName    name of the locality
     * @param asciiGreeting   greeting using ascii characters
     * @param unicodeGreeting greeting using unicode characters
     * @param formatStr       format string for the greeting
     */
    public Greeting(int localityID, String localityName, String asciiGreeting,
                    String unicodeGreeting, String formatStr) {
        this.localityID = localityID;
        this.localityName = localityName;
        this.asciiGreeting = asciiGreeting;
        this.unicodeGreeting = unicodeGreeting;
        this.formatStr = formatStr;
    }


    /**
     * Returns the locality id number.
     *
     * @return the locality id number
     */
    public int getLocalityID() {
        return localityID;
    }

    /**
     * Returns the locality name.
     *
     * @return the locality name
     */
    public String getLocalityName() {
        return localityName;
    }

    /**
     * Returns the ascii greeting. Just the greeting, no formatting.
     *
     * @return the ascii greeting
     */
    public String getAsciiGreeting() {
        return asciiGreeting;
    }

    /**
     * Returns the unicode greeting. Just the greeting, no formatting.
     *
     * @return the unicode greeting
     */
    public String getUnicodeGreeting() {
        return unicodeGreeting;
    }

    /**
     * Gets the unicode format string. This string will have a %s, so that the name can be
     * inserted into the greeting in the correct location.
     *
     * @return the format string with the greeting inserted into the format
     */
    public String getFormatStr() {
        String s = formatStr.replaceAll("(?<!%)%s", unicodeGreeting);
        return s.replaceAll("%%s", "%s");
    }

    /**
     * Returns the format string with the greeting inserted into the format.
     * This string will have a %s, so that the name can be inserted into the
     * greeting in the correct location.
     *
     * An example use is as follows:
     *
     *
     * Greeting g = new Greeting(2, "English");
     * // later in code
     * String name = "Alice";
     * String greet = String.format(g.getFormatStr(false), name);
     * System.out.println(greet); // Hello, Alice!
     *
     *
     * @param asciiOnly if true, only ascii characters will be used
     * @return the format string with the greeting inserted into the format
     */
    public String getFormatStr(boolean asciiOnly) {
        String greeting = "";
        if (asciiOnly) {
            greeting = asciiGreeting;
        } else {
            greeting = unicodeGreeting;
        }

        String s = formatStr.replaceAll("(?<!%)%s", greeting);
        return s.replaceAll("%%s", "%s");
    }

    /**
     * Returns the full greeting details as a string. Primarily for debugging purposes.
     * Example string format:
     * {localityID:1, localityName:"Hawaii", asciiGreeting:"Aloha", unicodeGreeting:"Aloha"}
     *
     * @return the full greeting details as a string
     */
    @Override
    public String toString() {
        return String.format(
                "{localityID:%d, localityName:\"%s\", asciiGreeting:\"%s\", unicodeGreeting:\"%s\"}",
                localityID, localityName, asciiGreeting, unicodeGreeting
        );
    }
}
