/*
Copyright (c) 2013, ETH Zurich (Stefan Mueller Arisona, Eva Friedrich)
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, 
  this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
  this list of conditions and the following disclaimer in the documentation
  and/or other materials provided with the distribution.
 * Neither the name of ETH Zurich nor the names of its contributors may be 
  used to endorse or promote products derived from this software without
  specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package ch.ethz.fcl.mpm.model;

public class SampleCalibrationModel extends BoxCalibrationModel {
	public SampleCalibrationModel() {
		super(10, 0.1f, 0.5f, 0.5f, 0.5f, 0.8f, 0.8f);
		reset();
	}

	private float[] faces;
	private float[] normals;
	private float[] colors;

	@Override
	public void reset() {
		float[] faces = new float[4 * UNIT_CUBE_FACES.length];
		addCube(faces, 0, -0.3f, -0.3f, 0.1f, 0.1f, 0.1f);
		addCube(faces, 1, 0.1f, -0.2f, 0.2f, 0.1f, 0.2f);
		addCube(faces, 2, 0f, 0f, 0.1f, 0.2f, 0.1f);
		addCube(faces, 3, 0.2f, 0.1f, 0.1f, 0.1f, 0.2f);
		setTriangles(faces, null);
	}

	@Override
	public float[] getModelFaces() {
		return faces;
	}

	@Override
	public float[] getModelNormals() {
		if (normals == null) {
			normals = calculateNormals(getModelFaces());
		}
		return normals;
	}

	@Override
	public float[] getModelColors() {
		return colors;
	}

	@Override
	public void setTriangles(float[] faces, float[] colors) {
		this.faces = faces;
		this.colors = colors;
		this.normals = null;
	}
}
