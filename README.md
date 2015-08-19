#SimpleItemDecoration

**Currently in active development**

**SimpleItemDecoration** is a simple library for adding dividers and offsets to Android's `RecyclerView` using `RecyclerView.ItemDecoration`.

It can be used to add both interior dividers and start/end offsets to RecyclerViews using `LinearLayoutManager` or `GridLayoutManager`.

###Usage

All of the ItemDecorations included can be added to your RecyclerView by calling `RecyclerView#addItemDecoration()`, passing in your desired ItemDecoration as a parameter.

####DividerItemDecoration

`DividerItemDecoration` is used to add interior dividers to a `RecyclerView` using a `LinearLayoutManager`. 

Its constructor takes in your preferred divider as a `Drawable`.

```java
Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_sample);

recyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));
```

####StartOffsetItemDecoration

`StartOffsetItemDecoration` is used to add an offset to the start of a `RecyclerView` using a `LinearLayoutManager`. 
If the `RecyclerView` is oriented vertically, the offset will be added to the top of the `RecyclerView`.
If the `RecyclerView` is oriented horizontally, the offset will be added to the lefthand side of the `RecyclerView`.

Its constructor takes in your preferred offset in pixels.

```java
int offsetPx = 10;

recyclerView.addItemDecoration(new StartOffsetItemDecoration(offsetPx));
```

####EndOffsetItemDecoration

`EndOffsetItemDecoration` is used to add an offset to the end of a `RecyclerView` using a `LinearLayoutManager`. 
If the `RecyclerView` is oriented vertically, the offset will be added to the bottom of the `RecyclerView`.
If the `RecyclerView` is oriented horizontally, the offset will be added to the righthand side of the `RecyclerView`.

Its constructor takes in your preferred offset in pixels.

```java
int offsetPx = 10;

recyclerView.addItemDecoration(new EndOffsetItemDecoration(offsetPx));
```

####GridDividerItemDecoration

`GridDividerItemDecoration` is used to add interior dividers to a `RecyclerView` using a `GridLayoutManager`. 

Its constructor takes in your preferred horizontal and vertical dividers, along with the number of columns in the grid.

```java
Drawable horizontalDividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_horizontal);
Drawable verticalDividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_vertical);
int numColumns = 2;

recyclerView.addItemDecoration(new GridDividerItemDecoration(horizontalDividerDrawable, verticalDividerDrawable, numColumns));
```

####GridTopOffsetItemDecoration

`GridTopOffsetItemDecoration` is used to add an offset to the top of a `RecyclerView` using a `GridLayoutManager`. 

Its constructor takes in your preferred offset in pixels and the number of columns in the grid.

```java
int offsetPx = 10;
int numColumns = 2;

recyclerView.addItemDecoration(new GridTopOffsetItemDecoration(offsetPx, numColumns));
```

####GridBottomOffsetItemDecoration

`GridBottomOffsetItemDecoration` is used to add an offset to the bottom of a `RecyclerView` using a `GridLayoutManager`. 

Its constructor takes in your preferred offset in pixels and the number of columns in the grid.

```java
int offsetPx = 10;
int numColumns = 2;

recyclerView.addItemDecoration(new GridBottomOffsetItemDecoration(offsetPx, numColumns));
```

###Project Setup

**SimpleItemDecoration** uses [JitPack.io](https://jitpack.io/#bignerdranch/simple-item-decoration) for hosting.
Add the following to your build.gradle:

The repository:

```groovy
repositories {
    // ...
    maven { url "https://jitpack.io" }
}
```

...and the dependency, replacing "\<release tag\>" with the name of the release tag:

```groovy
dependencies {
    // ...
    compile 'com.github.bignerdranch:simple-item-decoration:<release tag>'
}
```

###Contribute

Improvements/additions are encouraged. Clone the project with:

```
git clone https://github.com/bignerdranch/simple-item-decoration.git
```

###License

```
The MIT License

Copyright (c) 2015 Big Nerd Ranch

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```
