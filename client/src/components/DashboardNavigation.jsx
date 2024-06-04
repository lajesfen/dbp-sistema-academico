import React from 'react';
import Header from './dashboard/Header';
import DashboardHome from './dashboard/home/DashboardHome';
import DashboardCurricular from './dashboard/curricular/DashboardCurricular';
import { PiGraduationCapLight, PiHouseLight } from 'react-icons/pi';

export default function DashboardNavigation({ userData, selectedButton }) {
  switch (selectedButton) {
    case 0:
      return (
        <>
          <Header headerTitle={'Inicio'} Icon={PiHouseLight}/>
          <DashboardHome userData={userData}/>
        </>)
    case 1:
      return (
        <>
          <Header headerTitle={'Curricula'}  Icon={PiGraduationCapLight} />
          <DashboardCurricular userData={userData} />
        </>)
    default:
      return (
        <>
          
        </>)
  }
}