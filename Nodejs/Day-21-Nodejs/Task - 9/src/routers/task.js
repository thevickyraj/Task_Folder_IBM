const express = require("express");
const Task = require("../models/task");
const auth = require("../middleware/auth");

const router = express.Router();


// CREATE TASK
// POST /tasks

router.post("/tasks", auth, async (req, res) => {

    try {

        const task = new Task({
            description: req.body.description,
            owner: req.user._id
        });

        await task.save();

        res.status(201).send(task);

    } catch (error) {

        res.status(400).send({
            error: error.message
        });
    }
});


module.exports = router;