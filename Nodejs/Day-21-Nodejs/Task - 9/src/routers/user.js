const express = require("express");
const bcrypt = require("bcryptjs");

const User = require("../models/user");
const auth = require("../middleware/auth");

const router = express.Router();


// SIGN UP
router.post("/users", async (req, res) => {

    try {

        const user = new User(req.body);

        await user.save();

        const token = await user.generateAuthToken();

        res.status(201).send({
            user,
            token
        });

    } catch (error) {

        res.status(400).send({
            error: error.message
        });
    }
});


// LOGIN
router.post("/users/login", async (req, res) => {

    try {

        const { email, password } = req.body;

        const user = await User.findOne({ email });

        if (!user) {
            return res.status(400).send({
                error: "Unable to login"
            });
        }

        const isMatch = await bcrypt.compare(
            password,
            user.password
        );

        if (!isMatch) {
            return res.status(400).send({
                error: "Unable to login"
            });
        }

        const token = await user.generateAuthToken();

        res.send({
            user,
            token
        });

    } catch (error) {

        res.status(500).send({
            error: error.message
        });
    }
});


// GET PROFILE
router.get("/users/me", auth, async (req, res) => {

    res.send(req.user);

});


module.exports = router;