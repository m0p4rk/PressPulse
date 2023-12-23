1. **Web Scraping with Jsoup**:
   - Utilized the Jsoup library to extract news titles and URLs from a specific news website.
   - Implemented the `getNews` method to store news titles as keys and corresponding URLs as values in a `HashMap`.

2. **Use of Java Properties File**:
   - Created a `jsoup.properties` file to define the URL and selector needed for the Jsoup connection.
   - Used the `JSOUPUtil` class to read the properties file, making it accessible to the `NewsScraper` class.

3. **Database Storage Logic**:
   - Added a `saveNews` method to the `NewsDAO` class to store news data in the database.
   - Employed the `ON DUPLICATE KEY UPDATE` SQL clause to prevent the insertion of duplicate news titles into the database.

4. **Database Table Structure**:
   - Based on the provided database schema image, recognized the existence of `title` and `url` columns in the `summary` table.
   - Set a `UNIQUE` index on the `title` column to ensure that duplicate news titles are not stored.

5. **Service Layer Implementation**:
   - Implemented the `NewsService` class to include logic for storing the news data collected with Jsoup into the database.
   - Provided methods such as `getAllData`, `getUrlByTitle`, and `getTitleByUrl` for data retrieval and management.

6. **Code Optimization**:
   - Added a duplication check logic to efficiently store the data collected with Jsoup into the database.
   - Modified the `saveNews` method to check for the existence of the `title` before insertion to prevent duplicates.
