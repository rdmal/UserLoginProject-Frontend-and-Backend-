import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  
  loginForm = new FormGroup({
    id: new FormControl('',[Validators.minLength(9)]),
    uname: new FormControl('',[Validators.maxLength(20)]),
    pword: new FormControl('',[Validators.maxLength(20)])
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
