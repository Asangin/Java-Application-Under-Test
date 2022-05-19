# Vue 3 Authentication with JWT, Vuex and Vue Router

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).


## Note:
Open `src/services/auth-header.js` and modify `return` statement for appropriate back-end.

```js
export default function authHeader() {
  let user = JSON.parse(localStorage.getItem('user'));

  if (user && user.token) {
    return { Authorization: 'Bearer ' + user.token }; // for Spring Boot back-end
    // return { 'x-access-token': user.token };       // for Node.js Express back-end
  } else {
    return {};
  }
}
```

## Gradle plugin for npm build

```bash
gradle clean build
```

[Main repository](https://github.com/srs/gradle-node-plugin)
[Installing](https://github.com/srs/gradle-node-plugin/blob/master/docs/installing.md)
[Node plugin](https://github.com/srs/gradle-node-plugin/blob/master/docs/node.md)

[Build script example](https://github.com/tokuhirom/spring-vue-sample/blob/master/build.gradle)

## Maven plugin for npm build

```bash
mvn clean install
```

[npm maven plugin repository](https://github.com/aseovic/npm-maven-plugin)
