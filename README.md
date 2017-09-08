# mercari-android-test-master

Build an app that loads data from `all.json` which is stored in `assets`, and make the app look like the above screenshot.

- Written in a such way that data retrieval implementation can be easily replaced. For example, it is currenly loaded from `all.json` file 
  but in the near future we might want to fetch the data from network.

- In the item cell view, it needs to display item image from `photo`,
  title from `name`, and price from `price`.

- JSON representation of Java classes are pre-defined. See `com.mercari.mercaritest.data.model.Item` 
  and `com.mercari.mercaritest.data.model.Response`.

- For price background, use `item_price_background.xml` with a text style of `black_14_white`.

- For item name, use `regular_14_black_70op` text style.
