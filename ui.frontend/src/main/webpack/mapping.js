import CustomButton from './components/button/ts/button';
import HelloWorld from './components/helloworld/ts/helloworld';
import Teaser from './components/teaser/ts/teaser';
import Hero from './components/hero/ts/hero';

const Mapper = {
    'wknd/components/helloworld': HelloWorld,
    'wknd/components/teaser': Teaser,
    'wknd/components/hero': Hero,
    'wknd/components/button': CustomButton,
    'nt:unstructured': CustomButton,
    //title mapping 
}

export default Mapper;
