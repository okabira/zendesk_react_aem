import React from "react";
import { Button } from '@zendesk/greenhouse';

const CustomButton = (props) => {
   return <Button href="#">{props.title}</Button>;
}

export default CustomButton;