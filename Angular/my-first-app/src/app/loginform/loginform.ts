import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';

@Component({
  selector: 'app-loginform',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './loginform.html',
  styleUrl: './loginform.css'
})
export class Loginform {

  loginForm: FormGroup;

  constructor(private fb: FormBuilder) {

    this.loginForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(4)]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });

  }

  login() {

  if (this.loginForm.invalid) {
    alert("Please enter valid details.");
    return;
  }

  const username = this.loginForm.value.username;
  const password = this.loginForm.value.password;

  if (username === "admin" && password === "admin123") {
    alert("Login Successful");
  } else {
    alert("Invalid Username or Password");
  }
}
}