import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  
  loginForm = new FormGroup({
    Id: new FormControl('',[Validators.required, Validators.minLength(5)]),
    uname: new FormControl('',[Validators.required, Validators.maxLength(20)]),
    pword: new FormControl('',[Validators.required, Validators.pattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&]).{6,20}$")])
  })
  constructor() { }

  ngOnInit(): void {
  }
  get id() {
    return this.loginForm.get('id');
  }
  get uname() {
    return this.loginForm.get('uname');
  }
  get pword() {
   return  this.loginForm.get('pword');
  }
  onSubmit(){
    console.log(this.loginForm.value)
  }
}
