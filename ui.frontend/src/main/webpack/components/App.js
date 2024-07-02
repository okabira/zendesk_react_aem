import React from 'react';
import Mapper  from '../mapping.js';


const getComponentProperties = (components) => {
  const { [':type']: _, ...componentProperties } = components;
  return componentProperties;
}
const renderComponent = (props) => {
  
  let pageComponents = [];
  let listOfComponenetData = props.cqItems.root[':items']["container"][":items"]["hero"];
  // for (const component in listOfComponenetData) {
  let componentName = listOfComponenetData[":type"];
  let componentProperties = getComponentProperties(listOfComponenetData);
  if(Mapper.hasOwnProperty(componentName)) {
    pageComponents.push({ "componentName" : Mapper[componentName], "componentProps": componentProperties });
  }
  // }
  return pageComponents;
}

const renderAdditionalComponent = (props) => {
  console.log(props,'isnide additional component');
  let pageComponents = [];
  let listOfComponenetData = props[':items'];
  
  for (const addcomponent in listOfComponenetData) {
    let componentName = listOfComponenetData[addcomponent][":type"];
    let componentProperties = getComponentProperties(listOfComponenetData[addcomponent]);
    if (Mapper.hasOwnProperty(componentName)) {
      pageComponents.push({ "componentName" : Mapper[componentName], "componentProps": componentProperties });
    }
  }
  return pageComponents;
}

const App = (props) => {
  return (
    <div>
      {renderComponent(props).map((item => {
        return (
          <item.componentName {...item.componentProps}>
            {
              item.componentProps.additionalContent &&
              renderAdditionalComponent(item.componentProps.additionalContent).map((innerItem => {
                return (<innerItem.componentName {...innerItem}></innerItem.componentName>)
              }))
            }
          </item.componentName>
        )
      }))}
    </div>
  );
};

export default App;