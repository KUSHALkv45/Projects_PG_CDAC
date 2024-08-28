import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
import '../../css/DoctorLogin.css'
import NavigatonBar from './NavigationBar';
import DoctorLoginValidation from '../../services/DoctorLoginValidation';
import { DOCTOR_PATIENT_TREATMENT_TABLE_ROUTE, DOCTOR_REGISTER_ROUTE } from '../../constants/AppRouts';
import { loginDoctor } from '../../services/DoctorService';

const DoctorLogin = ()=>{
        const [values, setValues] = useState({
            userId: '',
            password:''
        })
        const Navigate = useNavigate();
        const [errors, setErrors] = useState({})

        const handleInput = (event) =>{
            setValues(prev =>({...prev, [event.target.name]:event.target.value}))
        }
        
        const handleSubmit=(event)=>{
            event.preventDefault();
            setErrors(DoctorLoginValidation(values));
            if(errors.userId === "" && errors.password === ""){
                loginDoctor(values)
                .then(res=>{
                        if(res.status === 200){
                            Navigate(DOCTOR_PATIENT_TREATMENT_TABLE_ROUTE);
                        }else {
                            alert("no record existed");
                        }
                } )
                .catch(err => console.log(err));
            }
        }

    return(
        <div className='d-flex justify-content-center align-items-center vh-100 back-g'>
            <div className='bg-white p-3 rounded doc-login-card'>
                <h2 className='text-center text'>Doctor's Login</h2>
                <form action="" onSubmit={handleSubmit}>
                    <div className='mb-3'>
                        <label htmlFor="userId"><strong>User ID</strong></label>
                        <input type="text" placeholder="Enter user ID" name="userId" 
                        onChange={handleInput} className='form-control rounded-0'></input>
                        {errors.userId && <span className='text-danger'>{errors.userId}</span>}
                    </div>

                    <div className='mb-3'>
                        <label htmlFor="password"><strong>Password</strong></label>
                        <input type="password" placeholder="Enter Password" name='password'
                        onChange={handleInput} className='form-control rounded-0'></input>
                        {errors.password && <span className='text-danger'>{errors.password}</span>}

                    </div>
                    <button type='submit' className='btn btn-success w-100 rounded-0'><strong>Log in</strong></button>
                    <br></br>
                    <p className='text-center mt-3'>Don't have an account yet?</p>
                    <Link to={DOCTOR_REGISTER_ROUTE} className='btn btn-default border w-100 bg-light rounded-0 link-button'>Create Account</Link>

                </form>
            </div>
        </div>
     
    );

}

export default DoctorLogin;