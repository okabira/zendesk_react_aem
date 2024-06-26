import React from 'react';
import Mapper  from '../mapping.js';


const getComponentProperties = (components) => {
    const { [':type']: _, ...componentProperties } = components;
    return componentProperties;
}
const renderComponent = (props) => {
    let pageComponents = [];
    let listOfComponenetData = props.cqItems.root[':items']["container"][":items"];
    for (const component in listOfComponenetData) {
        let componentName = listOfComponenetData[component][":type"];
        let componentProperties = getComponentProperties(listOfComponenetData[component]);
        if(Mapper.hasOwnProperty(componentName)) {
            pageComponents.push({ "componentName" : Mapper[componentName], "componentProps": componentProperties });
        }
    }
    return pageComponents;
}

const App = (props) => {
    return (
      <div>
        {renderComponent(props).map((item => {
            return <>
            <item.componentName {...item.componentProps}/>
            </>
        }))}
      </div>
    );
  };
  
export default App;