# PressPulse - Java Console News Application

## Overview
`PressPulse` is a Java-based console application that scrapes news data from the web and allows users to interact with and manage this data through a console interface. This application is ideal for users who prefer a simple, command-line interface for news management.

## Installation
1. **Java Installation**: Ensure Java Development Kit (JDK) is installed on your system. If not, download and install it from the [Oracle official website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. **Clone the Repository**: Clone the source code of the project to your local machine.
   ```bash
   git clone https://github.com/your-repository/PressPulse.git
   cd PressPulse
   ```
3. **Install Dependencies**: If the project uses Maven for dependency management, install the required dependencies.
   ```bash
   mvn install
   ```

## Execution
To start the application, navigate to the project directory and execute the following command:
```bash
java -cp target/PressPulse.jar news.view.NewsView
```

## Key Features
- **Scraping and Storing News**: Scrape the latest news from the web and store it in a local database.
- **Viewing All News**: Display all scraped news titles and URLs stored in the database.
- **Search by Title or URL**: Find a news URL using its title or vice versa.
- **Filter by Date and Keyword**: Retrieve news articles based on a specific date or keyword.
- **Display Latest News**: Show the most recent news items based on user-defined limits.

## How to Use
Upon running the application, the following menu options will be displayed:

```
1 - Scrape news and store in database
2 - Display all news from database
3 - Get title by URL
4 - Get URL by title
5 - Display news after a specific date
6 - Display the latest N news
7 - Display news by keyword
0 - Exit
```

Enter the number corresponding to the desired action. For example, to scrape news, enter `1`.

### Examples of User Interactions
- **Scrape News**: Enter `1` and the application will scrape and store news in the database.
- **Find News by Title**: Enter `4`, then input the news title when prompted to receive the corresponding URL.

## Error Handling
The application is equipped to handle common errors such as invalid inputs or issues during data fetching. In case of an error, an appropriate message will be displayed to the user.