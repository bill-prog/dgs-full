# dgs-be readme

### Latest build on render.com
[Game Store on Render](https://dgs-be.onrender.com)

### With Docker
1. Open Docker Desktop
2. Open IntelliJ
3. `gradle build`
4. `gradle bootBuildImage`
5. `docker run -d -p 8080:8080 dgs-be:0.0.1-SNAPSHOT`
6. App should be available at localhost:8080

### Without Docker
1. Open IntelliJ
2. `gradle build`
3. Open `DgsBeApplication`
4. Run `main` method