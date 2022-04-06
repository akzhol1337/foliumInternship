<h3>Association</h3>
<p>Associations defines a relationship between two objects</p>
<p>It means, one object has one or more references to other objects</p>

<h1>Aggregation vs Composition</h1>
<p>Aggregation and composition are special cases for association</p>

<h3>Composition</h3>
<p>Type of relationship, where one object can be part of only one another object</p>
<p>It makes strong relationship between objects</p>
<p>In that case, one object(parent object) fully controls life cycle of objects on which it depends</p>
<p>Dependecy can be created in constructor or any other method, and destroys with main object</p>
<p>There shouldn't be any access to object dependencies from outside of object</p>
<p>In example, we can see <code>building</code> and <code>address</code> objects, <code>address</code> object is created inside of <code>building</code> object, which means that there is a composition, and <code>building</code> is strongly dependent</p>

<h3>Aggregation</h3>
<p>Aggregation says that one object can be a part of another, it defines a weak relationship</p>
<p>In this relationship, object dependencies are created outside of the object, and therefore, can be used outside of our main object</p>
<p> For example, there are <code>building</code> object, which is the main object, and a list of <code>citizen</code> objects, we receive an already initialized reference to the list of <code>citizens</code> by the constructor, that's why it is an aggregation</p>