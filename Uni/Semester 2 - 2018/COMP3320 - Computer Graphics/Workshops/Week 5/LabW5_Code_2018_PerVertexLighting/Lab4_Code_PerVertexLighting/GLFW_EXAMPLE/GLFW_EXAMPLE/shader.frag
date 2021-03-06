#version 150

in vec3 Colour;
in vec2 Texcoord;
in vec3 Normal;

out vec4 outColor;

uniform sampler2D tex;

void main()
{
    outColor = texture(tex, Texcoord) * vec4(Colour, 1.0);
}

