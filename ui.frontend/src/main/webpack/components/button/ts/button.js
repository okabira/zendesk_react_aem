import React from "react";
import { Button } from '@zendesk/greenhouse';

const CustomButton = (props) => {

   return <Button href="#">{props.componentProps.text}</Button>;
}

export default CustomButton;