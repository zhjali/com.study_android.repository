/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\workspace\\task_2Server\\src\\com\\example\\task_1server\\IQueryInterface.aidl
 */
package com.example.task_1server;
public interface IQueryInterface extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.task_1server.IQueryInterface
{
private static final java.lang.String DESCRIPTOR = "com.example.task_1server.IQueryInterface";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.task_1server.IQueryInterface interface,
 * generating a proxy if needed.
 */
public static com.example.task_1server.IQueryInterface asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.task_1server.IQueryInterface))) {
return ((com.example.task_1server.IQueryInterface)iin);
}
return new com.example.task_1server.IQueryInterface.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_query:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
double _result = this.query(_arg0);
reply.writeNoException();
reply.writeDouble(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.task_1server.IQueryInterface
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public double query(java.lang.String fruit) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
double _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(fruit);
mRemote.transact(Stub.TRANSACTION_query, _data, _reply, 0);
_reply.readException();
_result = _reply.readDouble();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_query = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public double query(java.lang.String fruit) throws android.os.RemoteException;
}
