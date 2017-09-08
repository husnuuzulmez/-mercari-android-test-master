# mercari-android-test-master

Build an app that loads data from `all.json` which is stored in `assets`, and make the app look like the above screenshot.

- Write in a such way that data retrieval implementation can be easily replaced. For example, it is currenly loaded from `all.json` file 
  but in the near future we might want to fetch the data from network.

- In the item cell view, it needs to display item image from `photo`,
  title from `name`, and price from `price`.

- JSON representation of Java classes are pre-defined. See `com.mercari.mercaritest.data.model.Item` 
  and `com.mercari.mercaritest.data.model.Response`.

- For price background, use `item_price_background.xml` with a text style of `black_14_white`.

- For item name, use `regular_14_black_70op` text style.

- You are encouraged to build dependency graphs using [Dagger](https://google.github.io/dagger/)

- You are encouraged to use [RxJava](https://github.com/ReactiveX/RxJava)
- display `sold.png` as shown when `Item.status` equals to `sold_out`.

- Even though this app is relatively simple, please write code in "production ready" level; that is, write in a way that you would normally do on production app.

- Basic unit tests for bonus points
- Please use a known architecture with justification for your choice included, explained in README

When you have questions,
  please don't hesitate to ask
