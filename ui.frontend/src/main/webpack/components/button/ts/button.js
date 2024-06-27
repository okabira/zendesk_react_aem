import React from "react";
import { WhichButton } from '@zendesk/greenhouse';

const CustomButton = (props) => {
   return <WhichButton href="#">{props.text}</WhichButton>;
}

export default CustomButton;