const express = require("express");
const app = express();
const bodyParser = require("body-parser");
const mongoose = require("mongoose");

// Connect to MongoDB
mongoose.connect("mongodb://localhost:27017/my_database");

// Create a model for users
const User = mongoose.model("User", {
  username: String,
  password: String,
  email: String,
});

// Create a route for the signup form
app.post("/signup", (req, res) => {
  const { username, password, email } = req.body;

  // Create a new user
  const user = new User({
    username,
    password,
    email,
  });

  // Save the user to the database
  user.save((err) => {
    if (err) {
      res.send(err);
    } else {
      res.send({ message: "User created successfully" });
    }
  });
});

app.listen(3000, () => {
  console.log("Server started on port 3000");
});
