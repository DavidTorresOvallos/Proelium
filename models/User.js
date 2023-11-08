const mongoose  = require("mongoose");
const validator = require("validator");
const bcriypt   = require("bcryptsjs");
const jwt       = require("jsonwebtoken");

const userSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
    trim: true,
    lowercase: true,
  },
  email: {
    type: String,
    required: true,
    unique: true,
    lowercase: true,
    validate(value) {
      if (!validator.isEmail(value)) {
        throw new Error("Email is valid");
      }
    },
  },
  password: {
    type: String,
    required: true,
    minLength: 7,
    trim: true,
    validate(value) {
        if( value.toLowerCase().includes('password')) {
            throw new Error('password musn\'t contain password')
        }
    },
  },
  tokens: [{
    token: {
    type: String,
    required: true
      }
    }]
  }, {
  timestamps: true
});

const User = mongoose.model('User', userSchema)
module.exports = User