#version 150


void main()
{	
	//Compute direction of light from frag position in view space
	vec3 lightDisplacement = light_position.xyz - fragPositionView.xyz;
	
	//Distance to light
	float d = length(lightDisplacement);
	
	//Normalised light vector
	vec3 normalisedLightDisp = normalize(lightDisplacement);
	
	//Lambertian light equation for diffuse component
	vec4 diffuse = dot(normalisedLightDisp, fragNormalView.xyz) * light_colour;
	
	//Compute light reflection using (negate normalisedLightDisp because the light comes from the light to the surface)
	vec3 reflection = reflect(-normalisedLightDisp, fragNormalView.xyz);
	
	//Specular component.
	float shininess = 100;
	float specular_intensity = clamp(dot(reflection, -normalize(fragPositionView.xyz)),0,1);
	vec4 specular = pow(specular_intensity, shininess) * light_colour;
	
	//Ambient
	vec4 ambient = vec4(0.3,0.3,0.3,0.01);
    
    //Final total colour including diffuse, specular, ambient, falloff (with 1/d^2), texture and colour
    outColor =  ((diffuse + specular) * (1/(d*d)) + ambient) * texture(tex, Texcoord) * vec4(Colour, 1.0);

}

