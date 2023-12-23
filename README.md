# PressPulse

This Java-based application provides a straightforward command-line interface for scraping news data from a website using Jsoup and storing the scraped data into a database.

## Features

- **Scrape News Data**: Automatically fetches news titles and URLs from the specified news website.
- **Database Integration**: Saves the scraped news data into a database for persistent storage and retrieval.
- **Title and URL Fetching**: Retrieves the URL associated with a news title and vice versa, providing a quick lookup feature.
- **Duplicate Prevention**: Ensures that the same news title does not get stored in the database more than once.

## Setup

Before running the application, ensure that you have the following prerequisites installed:

- Java Development Kit (JDK)
- A MySQL server instance running and accessible
- Maven (for managing dependencies)

### Dependencies

The application uses the following Java libraries:

- `Jsoup`: For scraping web content.
- `MySQL Connector/J`: For database connectivity.

Dependencies are managed through Maven and specified in the `pom.xml` file.

## Configuration

1. Update the `jsoup.properties` file with the target URL and the document selector based on the HTML structure of the news website.
2. Configure your database connection settings in the `DBUtil` class.

## Usage

Run the application through the command line by navigating to the root directory and executing:

```sh
java -cp target/your-app.jar news.view.NewsView
```

You will be prompted with the following options:

- Enter `1` to scrape news and store it in the database.
- Enter `2` to input a URL and retrieve the corresponding news title.
- Enter `3` to input a news title and retrieve the corresponding URL.

## Important Notes

- The tool performs web scraping which is subject to the terms and conditions of the target website. Ensure that you have the right to scrape the website and that you comply with its `robots.txt` file.
- The database schema must have a `summary` table with `title` and `url` columns, where `title` has a UNIQUE constraint to prevent duplicates.

## Contributing

Contributions to enhance the functionality, improve the code structure, or fix bugs are welcome. Please feel free to fork the repository and submit pull requests.
