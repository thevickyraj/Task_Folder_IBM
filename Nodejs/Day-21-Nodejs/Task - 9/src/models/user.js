const mongoose = require("mongoose");
const bcrypt = require("bcryptjs");
const jwt = require("jsonwebtoken");

const userSchema = new mongoose.Schema({

    name: {
        type: String,
        required: true,
        trim: true
    },

    email: {
        type: String,
        required: true,
        unique: true,
        trim: true
    },

    password: {
        type: String,
        required: true,
        minlength: 7
    },

    tokens: [{
        token: {
            type: String,
            required: true
        }
    }]
});


// Hash password before saving
userSchema.pre("save", async function () {

    if (!this.isModified("password")) {
        return;
    }

    this.password = await bcrypt.hash(this.password, 8);
});


// Generate JWT token
userSchema.methods.generateAuthToken = async function () {

    const user = this;

    const token = jwt.sign(
        {
            _id: user._id.toString()
        },
        "mysecretkey"
    );

    user.tokens = user.tokens.concat({ token });

    await user.save();

    return token;
};


// Create User model
const User = mongoose.model("User", userSchema);

module.exports = User;