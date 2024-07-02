import React from 'react';
import Mapper  from '../mapping.js';


const getComponentProperties = (components) => {
    const { [':type']: _, ...componentProperties } = components;
    return componentProperties;
}
const renderComponent = (props) => {
  console.log("Inside render")
    let pageComponents = [];
    let listOfComponenetData = props.cqItems.root[':items']["container"][":items"]["container"][":items"]["hero"];
    console.log(listOfComponenetData);
    // for (const component in listOfComponenetData) {
        let componentName = listOfComponenetData[":type"];
        let componentProperties = getComponentProperties(listOfComponenetData);
        if(Mapper.hasOwnProperty(componentName)) {
            pageComponents.push({ "componentName" : Mapper[componentName], "componentProps": componentProperties });
        }
   // }
    console.log("PageComponenets", pageComponents);
    return pageComponents;
}

const App = (props) => {
  console.log("Hello", props);
    return (
      <div>
        {renderComponent(props).map((item => {
            return (<item.componentName {...item.componentProps}/>)
        }))}
        
      </div>
    );
  };
  
export default App;