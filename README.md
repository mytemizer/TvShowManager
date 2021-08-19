# TvShowManager
Tv Show Manager app where you can keep track of the tv shows you follow

## Technologies I used

- **Apollo Client** for backend communication (request&response)
- **OkHttp** for Apollo Client requests
- **LiveData** to update ui with corresponding changes
- **Hilt** for Dependency Injection
- **Coroutine** is used to carry data to view in background
- **ViewBinding** for binding views to the corresponding pages
- **Constraint Layout** for creating layouts that is suitable with different languages and preventing overdraw issue
- **Navigation Component* for navigation between pages in a safe way

## Architecture

- **MVVM** architecture is used
- **Repository Pattern** is used

## How To Use
- You will see 2 buttons in main page. First one is for adding tv show, other one is to show tv show list.
- There are 2 optional input in adding tv show page. You can add tv show by typing only name.
- If you want to add tv show release date, you need to enter a date in "yyyy-MM-dd" format.
