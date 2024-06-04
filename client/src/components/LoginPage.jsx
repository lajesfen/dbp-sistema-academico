import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { GoogleLogin } from '@react-oauth/google';
import jwt_decode from 'jwt-decode';
import PopupMessage from './login/PopupMessage';
import loginbackground from '../assets/login-background.webp'
import uteclogo from '../assets/utec-logo.png'

export default function Login() {
    const [showPopup, setShowPopup] = useState(false);
    const navigate = useNavigate();

    const openPopup = () => setShowPopup(true);
    const closePopup = () => setShowPopup(false);

    return (
        <div className='h-screen z-0 flex'>
            <div className='absolute'>
                <img src={loginbackground} alt='UTEC Background' className='flex h-screen w-screen object-cover'></img>
            </div>
            <div className='inset-y-0 z-10 bg-[#FFF] min-w-[340px] flex flex-col justify-center items-center shadow'>
                <div className='flex flex-col items-center'>
                    <img src={uteclogo} alt='UTEC Logo' className='w-[260px]'></img>
                </div>
                <div className='text-center mt-40'>
                    <GoogleLogin
                        onSuccess={credentialResponse => {
                            console.log(credentialResponse);
                            console.log(jwt_decode(credentialResponse.credential));
                            if (jwt_decode(credentialResponse.credential)['hd'] !== 'utec.edu.pe') {
                                openPopup();
                            } else {
                                console.log('GoogleOauth2 CHECK');
                                navigate('/oauth/login', { state: credentialResponse });
                            }
                        }}
                        onError={() => {
                            console.log('Login Failed');
                        }}
                    />
                    {showPopup && <PopupMessage message={'Inicia sesión con una cuenta válida.'} onClose={closePopup} />}
                    <button className='underline text-text_second mt-4 hover:text-text_sub text-[12px]'>
                        Ayuda
                    </button>
                </div>
            </div>
        </div>
    );
}