# WebMan

A [re-frame](https://github.com/Day8/re-frame) application designed to build different websites sharing same structure
but different content using one build process.

## Development Mode

If you use Emacs, navigate to a clojurescript file and start a figwheel REPL with `cider-jack-in-clojurescript` or (`C-c M-J`).


If you want to run the server on your terminal instead of Emacs just do as follows:

```
$ lein figwheel dev
```

in bother cases you should be able to connect to [http://localhost:3449](http://localhost:3449)


### Compile css:

Compile css file automatically.

```
lein sass
```

### Run tests:

```
lein clean
lein doo phantom test once
```

The above command assumes that you have [phantomjs](https://www.npmjs.com/package/phantomjs) installed. However, please note that [doo](https://github.com/bensu/doo) can be configured to run cljs.test in many other JS environments (chrome, ie, safari, opera, slimer, node, rhino, or nashorn).

## Production Build


To compile clojurescript to javascript:

```
lein clean
lein cljsbuild once min
```
