---
title: Volley
type: Homework
duration: "1:30"
creator:
    name: Charlie
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Volley Homework

> ***Note:*** _This homework can be a pair programming activity or done independently._

## Exercise

After Retrofit, the next most popular neworking library for Android is Google's Volley.
In this homework, you will use the [Volley documentation](https://developer.android.com/training/volley/index.html) as a guide and implement Volley to make network calls to Walmart's API.

#### Requirements

- Replicate your [Networking in Android Lab](https://github.com/ga-adi-macaron/networking-in-android-lab) using Volley to make all your network calls
- Make the same calls to the [Walmart API](https://developer.walmartlabs.com/io-docs) that you made for the lab, and display the products to your user
- Use Volley's `RequestQueue` to perform API calls asynchronously on a worker thread (instead of the AsyncTask approach used in the lab)

**Bonus:**
- If a user clicks on of the product buttons while a network request is still pending, cancel the existing request and launch the new one
- Replace your old code that creates `JSONObject`s and `JSONArray`s manually by using GSON instead

#### Starter code

You have three options:

1. Build this app from scratch
1. Start with your code from the [Networking in Android Lab](https://github.com/ga-adi-macaron/networking-in-android-lab)
1. Start with the provied solution code from the [Networking in Android Lab](https://github.com/ga-adi-macaron/networking-in-android-lab)

#### Deliverable

Submit a pull request with your completed app. If you work with a partner, only one person needs to submit, but put both names in the pull request title.

Here is a gif that demonstrates the required functionality:

<p align="center">
  <img src="./screenshots/networking-lab.gif" width="320">
</p>

## Resources

- [Volley Docs](https://developer.android.com/training/volley/index.html)
- [Walmart API Docs](https://developer.walmartlabs.com/io-docs)

---

## Licensing
1. All content is licensed under a CC­BY­NC­SA 4.0 license.
2. All software code is licensed under GNU GPLv3. For commercial use or alternative licensing, please contact [legal@ga.co](mailto:legal@ga.co).
